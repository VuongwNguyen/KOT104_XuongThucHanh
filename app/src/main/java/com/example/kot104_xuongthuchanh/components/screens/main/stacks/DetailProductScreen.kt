package com.example.kot104_xuongthuchanh.components.screens.main.stacks

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.helper.RetrofitAPI
import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts
import com.example.kot104_xuongthuchanh.httpModel.products.DetailProductResponse
import com.example.kot104_xuongthuchanh.httpModel.products.ProductsByCategoryResponse
import com.example.kot104_xuongthuchanh.models.Cart

data class Product(val name:String, val image: Int, val rate:Double)
 val ItemProduct = listOf(
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
 )
@Composable
fun DetailProductScreen(
    navControllerContainer: NavHostController,
    productId: String?,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>,
    addToCart: (Cart) -> Unit
) {

    var quantity = remember {
        mutableStateOf(1)
    }

    var productDetail by remember {
        mutableStateOf(dataProducts(
            id = "", name = "", price = null, image_url = "", categoryId = "", description = "", createdAt = "", updatedAt = ""
        ))
    }

    fun callBackDetailProduct(it: DetailProductResponse) {
        productDetail = it.data.products
    }

    fun getDetailProduct(){
        try {
            val api = RetrofitAPI()
            if (productId != null){
                api.getDetailProduct(productId) {
                    if (it != null) {
                        callBackDetailProduct(it)
                    }
                }
            }
        }catch (e: Exception){
            Log.d(">>>>", "getDetailProduct: ${e.message}")
        }
    }

    getDetailProduct()

    fun clickChangeQuantity(number: Int){
        if (number < 0){
            if (quantity.value == 1 ){
                isShowBottomSheet.value = true
                textContentBottomSheet.value = "Số lượng không thể nhỏ hơn 1"
            }else{
                quantity.value += number
            }
        }else{
            quantity.value += number
        }
    }

    var Products = remember {
        mutableStateListOf<dataProducts>()
    }

    var nameCategory = remember {
        mutableStateOf("")
    }

    fun callBackProductsByCategory(it: ProductsByCategoryResponse) {
        Products.clear()
        Products.addAll(it.data.products ?: listOf())
        nameCategory.value = it.data.nameCategory.name
    }

    fun getProductsByCategory(){
        try {
            val api = RetrofitAPI()
            if (productDetail.categoryId != null){
                api.getProductsByCategory(categoryId = productDetail.categoryId){
                    if (it != null){
                        callBackProductsByCategory(it)
                    }
                }
            }
        }catch (e: Exception){
            Log.d(">>>>", "getProductByCategory: ${e.message}")
        }
    }

    getProductsByCategory()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff263238))
            .padding(horizontal = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .height(198.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color.White),
            ) {
                AsyncImage(
                    model = productDetail.image_url,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .zIndex(0f),
                    contentScale = ContentScale.FillHeight
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .zIndex(1f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_back_container2),
                        contentDescription = null,
                        modifier = Modifier
                            .height(38.dp)
                            .width(38.dp)
                            .clickable { navControllerContainer.popBackStack() }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_love_choose),
                        contentDescription = null,
                        modifier = Modifier
                            .height(38.dp)
                            .width(38.dp)
                    )
                }
            }
            Text(
                text = "${productDetail.name}",
                style = TextStyle(
                    color = Color(0xffFF7400),
                    fontWeight = FontWeight(500),
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ),
                modifier = Modifier
                    .padding(top = 20.dp)
            )
            Row (
                modifier = Modifier.padding(top = 30.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_sao_feedback),
                    contentDescription = null,
                    modifier = Modifier
                        .height(17.dp)
                        .width(17.dp)
                )
                Text(
                    text = "4,5",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight(500),
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                    modifier = Modifier
                        .padding(start = 7.dp)
                )
                Text(
                    text = "(30+)",
                    style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight(500),
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                    modifier = Modifier
                        .padding(start = 7.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(start = 30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_shiper_lab3),
                        contentDescription = null,
                        modifier = Modifier
                            .height(17.dp)
                            .width(17.dp)
                    )
                    Text(
                        text = "Free delivery",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icon_time_lab3),
                        contentDescription = null,
                        modifier = Modifier
                            .height(17.dp)
                            .width(17.dp)
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "10-15 mins",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        ),
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${productDetail.price}$",
                    style = TextStyle(
                        color = Color(0xff22A45D),
                        fontWeight = FontWeight(500),
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Image(
                        painter = painterResource(id = R.drawable.btn_minus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { clickChangeQuantity(-1) })

                    Text(
                        text = "${quantity.value}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = Color(0xff4285F4),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.btn_plus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { clickChangeQuantity(1) })
                }
            }

            Text(
                text = "${productDetail.description}",
                style = TextStyle(
                    color = Color(0xffC0C0C0),
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular  )),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${nameCategory.value}",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight(500),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(
                    text = "see all",
                    style = TextStyle(
                        color = Color(0xff22A45D),
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clickable { navControllerContainer.navigate("ProductInCategoryScreen/${productDetail.categoryId}") }
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)

            ){
                items(Products){ item ->
                    ListProduct(item)
                }
            }

        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
                .align(Alignment.BottomCenter)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                TextButton(
                    modifier = Modifier
                        .width(250.dp)
                        .height(48.dp)
                        .background(
                            color = Color(0xFFcFF7400),
                            shape = MaterialTheme.shapes.small
                        ),
                    onClick = {addToCart(Cart(Product = productDetail, quantity = quantity))}
                ) {
                    Text(
                        text ="Add to cart", color = Color(0xFFcFFFFFF,),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                        )
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_warning), contentDescription=  null,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Composable
fun ListProduct(item: dataProducts){
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(250.dp)
            .clip(RoundedCornerShape(8))
            .background(Color.White),
    ) {
        AsyncImage(
            model = item.image_url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .padding(top = 10.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            ) {
                Text(
                    text = "4.5",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                    ),
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_sao_feedback),
                    contentDescription = null,
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Text(
                    text = "(30+)",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                    ),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.icon_love), contentDescription=  null,
                modifier = Modifier
                    .height(40.dp)
                    .width(150.dp)
                    .padding(start = 100.dp)
                    .padding(top = 10.dp)
                )
        }
    }
    
    Spacer(modifier = Modifier.width(10.dp))
}

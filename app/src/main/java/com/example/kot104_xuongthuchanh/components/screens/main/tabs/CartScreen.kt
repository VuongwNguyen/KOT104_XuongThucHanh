package com.example.kot104_xuongthuchanh.components.screens.main.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.models.Cart
import com.example.kot104_xuongthuchanh.ui.theme.ColorBackground

@Composable
fun CartScreen(
    navControllerContainer: NavHostController,
    listCart: SnapshotStateList<Cart>,
    changeQuantityCart: (Cart, Number: Int) -> Unit,
    orderCart: () -> Unit,
    deleteItemCart: (Cart) -> Unit
) {

    var total = remember { mutableStateOf(0) }

    fun tinhTotal() {
        var sum = 0
        for (cart in listCart){
            sum += cart.Product.price!! * cart.quantity.value
        }
        total.value = sum
    }


    tinhTotal()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
            .padding(20.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Your Cart",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                color = Color(0xffFF7400)
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn {
                items(
                    items = listCart,
                    itemContent = {
                        item: Cart ->
                        itemCart(item = item, changeQuantityCart, deleteItemCart)
                    }
                )
            }
        }

        Column (
            modifier = Modifier.zIndex(1f)
                .align(Alignment.BottomCenter)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Total:",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                    color = Color(0xff808080)
                )

                Text(
                    text = "${total.value} $",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_10pt_bold)),
                    color = Color.White
                )
            }

            ElevatedButton(
                onClick = { orderCart() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#FF7400"))
                )
            ) {
                Text(
                    text = "Check out",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                )
            }
        }

    }
}

@Composable
fun itemCart(
    item: Cart,
    changeQuantityCart: (Cart, Number: Int) -> Unit,
    deleteItemCart: (Cart) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        AsyncImage(
            model = item.Product.image_url,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10)),
            contentScale = ContentScale.FillBounds)

        Column (
            modifier = Modifier
                .fillMaxHeight()
                .width(234.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "${item.Product.name}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = Color(0xff395998)
                    )

                    Image(painter = painterResource(
                        id = R.drawable.icon_delete),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { deleteItemCart(item) }
                    )
                }

                Text(text = "with baked salmon",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(0xff8C8A9D))
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "${item.Product.price} $",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color(0xff22A45D))

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Image(
                        painter = painterResource(id = R.drawable.btn_minus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { changeQuantityCart(item, -1) })

                    Text(
                        text = "${item.quantity.value}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = Color(0xff4285F4),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.btn_plus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { changeQuantityCart(item, 1) })
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}

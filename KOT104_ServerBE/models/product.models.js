const { DataTypes } = require('sequelize');
const { sequelize } = require('../helpers/database.connection');
const category = require('./category.models');
const product = sequelize.define('product', {
    id: {
        type: DataTypes.UUID,
        defaultValue: DataTypes.UUIDV4,
        primaryKey: true
    },
    name: {
        type: DataTypes.STRING,
        allowNull: false
    },
    description: {
        type: DataTypes.STRING,
        allowNull: false
    },
    price: {
        type: DataTypes.DOUBLE,
        allowNull: false
    },
    image_url: {
        type: DataTypes.STRING,
        allowNull: false
    },
    categoryId: {
        type: DataTypes.UUID,
        allowNull: false,
        references: {
            model: 'category',
            key: 'id'
        }
    }
}, {
    tableName: 'product',
    timestamps: true
});

category.hasMany(product, { foreignKey: 'categoryId' });
product.belongsTo(category, { foreignKey: 'categoryId' });

async function multipleCreateProduct(products) {
    try {
        for (const pr of products) {
            const existingProduct = await product.findOne({ where: { name: pr.name } });
            if (!existingProduct) {
                await product.create(pr);
            }
        }
    } catch (error) {
        console.log("Unable to add products:", error);
    }
}
const products = [
    {
        name: 'Macbook Pro',
        description: 'Macbook Pro description',
        price: 2000,
        image_url: 'https://i.pinimg.com/236x/1f/af/2a/1faf2a42d3c7b46ced2b270416915249.jpg',
        categoryId: '2657dbf8-84eb-40bf-a080-1d4b4885471f'
    },
    {
        name:'Laptop HP',
        description: 'Laptop HP description',
        price: 1000,
        image_url: 'https://i.pinimg.com/236x/05/71/a1/0571a140c8f2c73d60ad88ffd4a2bbb4.jpg',
        categoryId: '2657dbf8-84eb-40bf-a080-1d4b4885471f'
    },
    {
        name: 'Laptop Dell',
        description: 'Laptop Dell description',
        price: 1500,
        image_url: 'https://i.pinimg.com/236x/3a/70/02/3a7002b34101b95869af24324e7e0201.jpg',
        categoryId: '2657dbf8-84eb-40bf-a080-1d4b4885471f'
    },
    {
        name: 'Laptop Lenovo',
        description: 'Laptop Lenovo description',
        price: 1200,
        image_url: 'https://i.pinimg.com/236x/8a/22/98/8a22982a15199c4e580fda1f3347dbac.jpg',
        categoryId: '2657dbf8-84eb-40bf-a080-1d4b4885471f'
    },
    {
        name: 'Smartphone Samsung',
        description: 'Smartphone Samsung description',
        price: 800,
        image_url: 'https://i.pinimg.com/236x/7c/9c/d5/7c9cd52ef6c835c9434d6f02847292bd.jpg',
        categoryId: '792cacff-3699-4dd3-b9b9-ba8427ad2e24'
    },
    {
        name: 'Smartphone iPhone',
        description: 'Smartphone iPhone description',
        price: 1000,
        image_url: 'https://i.pinimg.com/236x/30/b3/fe/30b3fe361913bb3bc4be446b44cb9a36.jpg',
        categoryId: '792cacff-3699-4dd3-b9b9-ba8427ad2e24'
    },
    {
        name: 'Smartphone Xiaomi',
        description: 'Smartphone Xiaomi description',
        price: 500,
        image_url: 'https://i.pinimg.com/736x/1c/bd/e8/1cbde81850a3c9b4e288dfd79c5bc588.jpg',
        categoryId: '792cacff-3699-4dd3-b9b9-ba8427ad2e24'
    },
    {
        name: 'Smartphone Huawei',
        description: 'Smartphone Huawei description',
        price: 600,
        image_url: 'https://i.pinimg.com/236x/47/51/c1/4751c16940762f95e6392cd7fd8b86d2.jpg',
        categoryId: '792cacff-3699-4dd3-b9b9-ba8427ad2e24'
    },
    {
        name: 'Tablet Samsung',
        description: 'Tablet Samsung description',
        price: 400,
        image_url: 'https://i.pinimg.com/236x/3e/7f/57/3e7f57c0eeb65e48bf4266f14c32210c.jpg',
        categoryId: '600f496a-1bbe-41e9-aa48-8845dd2f7818'
    },
    {
        name: 'Tablet iPad',
        description: 'Tablet iPad description',
        price: 500,
        image_url: 'https://i.pinimg.com/236x/ea/b3/9c/eab39cfd9c3867494c34876f4f9ed0dc.jpg',
        categoryId: '600f496a-1bbe-41e9-aa48-8845dd2f7818'
    },
    {
        name: 'Tablet Lenovo',
        description: 'Tablet Lenovo description',
        price: 300,
        image_url: 'https://i.pinimg.com/236x/9d/4a/45/9d4a45fac8203ea78e662c567949b269.jpg',
        categoryId: '600f496a-1bbe-41e9-aa48-8845dd2f7818'
    },
    {
        name: 'Tablet Huawei',
        description: 'Tablet Huawei description',
        price: 350,
        image_url: 'https://i.pinimg.com/236x/f8/75/e6/f875e6ea2357a09b23631a47c064bcd2.jpg',
        categoryId: '600f496a-1bbe-41e9-aa48-8845dd2f7818'
    },
    {
        name: 'Smartwatch Samsung',
        description: 'Smartwatch Samsung description',
        price: 300,
        image_url: 'https://i.pinimg.com/236x/7f/a9/43/7fa943fdc21d4177600e33daee7ff5dc.jpg',
        categoryId: '16d31e82-617b-4973-895e-1fcb800048c9'
    },
    {
        name: 'Smartwatch Apple',
        description: 'Smartwatch Apple description',
        price: 400,
        image_url: 'https://i.pinimg.com/236x/7d/97/30/7d97309f1a0aadfd1475c491932ee5cc.jpg',
        categoryId: '16d31e82-617b-4973-895e-1fcb800048c9'
    },
    {
        name: 'Smartwatch Xiaomi',
        description: 'Smartwatch Xiaomi description',
        price: 200,
        image_url: 'https://i.pinimg.com/236x/e7/eb/86/e7eb861a671845d0a7f4837de50472f6.jpg',
        categoryId: '16d31e82-617b-4973-895e-1fcb800048c9'
    },
    {
        name: 'Smartwatch Huawei',
        description: 'Smartwatch Huawei description',
        price: 250,
        image_url: 'https://i.pinimg.com/236x/38/dc/54/38dc549c01e752aa948a57b199267199.jpg',
        categoryId: '16d31e82-617b-4973-895e-1fcb800048c9'
    },
    {
        name: 'Desktop HP',
        description: 'Desktop HP description',
        price: 1500,
        image_url: 'https://i.pinimg.com/236x/3b/50/c8/3b50c8ebb61d1b3ac7c86ed01b218094.jpg',
        categoryId: '82228402-718c-4764-8a7f-e4de033e2648'
    },
    {
        name: 'Desktop Dell',
        description: 'Desktop Dell description',
        price: 2000,
        image_url: 'https://i.pinimg.com/236x/93/b9/ec/93b9eca9e497c3290f9e2fdfe23ca729.jpg',
        categoryId: '82228402-718c-4764-8a7f-e4de033e2648'
    },
    {
        name: 'Desktop Lenovo',
        description: 'Desktop Lenovo description',
        price: 1800,
        image_url: 'https://i.pinimg.com/236x/54/0f/01/540f01a8e244234ab4a297ff3130c6cf.jpg',
        categoryId: '82228402-718c-4764-8a7f-e4de033e2648'
    },
    {
        name: 'Desktop Acer',
        description: 'Desktop Acer description',
        price: 1600,
        image_url: 'https://i.pinimg.com/236x/c3/b5/82/c3b582fe011d26fd74ed75acdcd5e72c.jpg',
        categoryId: '82228402-718c-4764-8a7f-e4de033e2648'
    }
];

multipleCreateProduct(products)


module.exports = product;
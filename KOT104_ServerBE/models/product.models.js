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



module.exports = product;
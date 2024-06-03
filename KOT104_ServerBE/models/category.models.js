const { DataTypes } = require('sequelize');
const { sequelize } = require('../helpers/database.connection');

const category = sequelize.define('category', {
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
}, {
    tableName: 'category',
    timestamps: true
});


async function multipleCreateCategory(categories) {
    try {
        for (let i = 0; i < categories.length; i++) {
            const category1 = await category.findOne({ where: { name: categories[i].name } });
            if (!category1) {
                await category.create(categories[i]);
            }
        }
    } catch (error) {
        console.error('Unable to add categories:', error);
    }
};




module.exports = category;
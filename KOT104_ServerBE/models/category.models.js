const {DataTypes} = require('sequelize');
const {sequelize} = require('../helpers/database.connection');

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


module.exports = category;
const { DataTypes } = require('sequelize');
const { sequelize } = require('../helpers/database.connection');

const account = sequelize.define('account', {
    id: {
        type: DataTypes.UUID,
        defaultValue: DataTypes.UUIDV4,
        primaryKey: true
    },
    fullname: {
        type: DataTypes.STRING,
        allowNull: false
    },
    email: {
        type: DataTypes.STRING,
        allowNull: false
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false
    },
}, {
    tableName: 'account',
    timestamps: true
});

module.exports = account;
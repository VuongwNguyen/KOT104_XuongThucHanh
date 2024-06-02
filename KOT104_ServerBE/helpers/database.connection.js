const { Sequelize } = require('sequelize');
const mysql = require('mysql2/promise');
require('dotenv').config();

const databaseName = process.env.DATABASE_NAME || 'SampleDB';
const databaseUser = process.env.DATABASE_USER || 'root';
const databasePassword = process.env.DATABASE_PASSWORD || '0134';

const sequelize = new Sequelize(databaseName, databaseUser, databasePassword, {
    host: 'localhost',
    dialect: 'mysql',
    logging: false
});

(async () => {
    try {
        const connection = await mysql.createConnection({
            host: 'localhost',
            user: databaseUser,
            password: databasePassword
        });
        await connection.query(`CREATE DATABASE IF NOT EXISTS ${databaseName}`);
        console.log(`Database ${databaseName} created successfully`);
    } catch (error) {
        console.error('Unable to create database:', error);
    }
})();



async function databaseConnection() {
    try {
        await sequelize.authenticate();
        await sequelize.sync({ alter: true });
        // nếu database chưa tồn tại thì sequelize sẽ tạo mới database
        console.log('Connection has been established successfully.');
    } catch (error) {
        console.error('Unable to connect to the database:', error);
        if (error.original.errno === 1049) {
            console.error('Database does not exist');

        }
    }
}

module.exports = { databaseConnection, sequelize };
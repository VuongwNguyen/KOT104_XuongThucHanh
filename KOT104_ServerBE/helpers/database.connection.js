const { Sequelize } = require('sequelize');
const mysql = require('mysql2/promise');
// require('dotenv').config();


const databaseName = process.env.DATABASE_NAME || 'SampleDB';
const databaseUser = process.env.DATABASE_USER || 'root';
const databasePassword = process.env.DATABASE_PASSWORD || '0134';
const databaseHost = process.env.DATABASE_HOST || 'localhost';
const port = process.env.DATABASE_PORT || 3306;

const sequelize = new Sequelize(databaseName, databaseUser, databasePassword, {
    host: databaseHost,
    dialect: 'mysql',
    logging: false,
    port: port,
});

(async () => {
    try {
        const connection = await mysql.createConnection({
            host: databaseHost,
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
    }
}

module.exports = { databaseConnection, sequelize };
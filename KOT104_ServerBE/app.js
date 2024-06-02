var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var createError = require('http-errors');
var helmet = require('helmet');
var app = express();

const { databaseConnection } = require('./helpers/database.connection');
const indexRouter = require('./routes/index');


databaseConnection(); // connect to database

app.use(helmet());
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use('/', indexRouter);
app.use(function (req, res, next) {
    next(createError(404));// catch 404 and forward to error handler
});
app.use(function (err, req, res, next) {
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};// set locals, only providing error in development
    res.status(err.code || 500).json({
        message: err.message,
        status: err.status
    });
    console.log(err.stack);
});

module.exports = app;

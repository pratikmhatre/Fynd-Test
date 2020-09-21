package com.example.cavista_test.utils


enum class Result { SUCCESS, FAILURE, AUTH_FAILURE, SERVER_ERROR }
class NetworkResponse<T:Any>(val result: Result, val data: T?)
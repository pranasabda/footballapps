package com.prana.footballapps.api

import java.net.URL


//membuat class request
class ApiRequest {

    // fungsi untuk melakukan request
    fun doRequest(url: String): String {
        return URL(url).readText()
    }

}

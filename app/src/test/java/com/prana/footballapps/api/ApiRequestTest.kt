package com.prana.footballapps.api

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ApiRequestTest {

    @Test
    fun doRequest() {
        val apiRequest = mock(ApiRequest::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League\""
        apiRequest.doRequest(url)
        verify(apiRequest).doRequest(url)
    }
}
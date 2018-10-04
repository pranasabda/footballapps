package com.prana.footballapps

import com.prana.footballapps.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class ContextProviderTest : CoroutineContextProvider(){
    override val main: CoroutineContext = Unconfined
}
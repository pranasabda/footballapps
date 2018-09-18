package com.prana.footballapps.model

// doc : Prana Sabda, val events --> harus sesuai dengan Array JSON API nya.
// check : https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328
// { "events": [ { } ] } --> konstruksi APInya
data class MatchDataItemResponse (val events: List<MatchDataItem>)
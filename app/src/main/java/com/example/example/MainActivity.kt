package com.example.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo3.ApolloClient

class MainActivity : AppCompatActivity() {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(LaunchListQuery()).execute()

            Log.d("LaunchList", "Success ${response.data}")
        }
    }
}
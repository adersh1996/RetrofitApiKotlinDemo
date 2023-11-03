package com.project.adersh.retrofitapikotlindemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.adersh.retrofitapikotlindemo.adapter.CustomAdapter
import com.project.adersh.retrofitapikotlindemo.api.ApiInterface
import com.project.adersh.retrofitapikotlindemo.api.ApiUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)

        val userApi = ApiUtility.getInstance().create(ApiInterface::class.java)

        lifecycleScope.launch {

            val result = userApi.getUsers()

            //You can use the below code to make safe call
//            if (result.body() != null) {
//                val root = result.body()
//                if (root != null){
//                    val customAdapter = CustomAdapter(applicationContext,root)
//                    recyclerView.adapter = customAdapter
//                }
            // Log.d("resu","onCreate: ${result.body()!!.get(1).login}")

            // the below code make the safe call more simpler and readable by using let

            result.body()?.let { root ->
                val customAdapter = CustomAdapter(applicationContext, root)
                recyclerView.adapter = customAdapter

            }

        }
    }
}

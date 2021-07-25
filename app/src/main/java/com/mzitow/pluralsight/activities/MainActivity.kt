package com.mzitow.pluralsight.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mzitow.pluralsight.app.Constants
import com.mzitow.pluralsight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view binding, get the root layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        //set the view as the root
        setContentView(view)

        //set the toolbar
        setSupportActionBar(binding.toolbar)

    }

    //save the user name to sharedPreference
    fun saveName(view : View){

    }

    //list repos after search and after passing data to the displayActivity
    fun listRepositories(view : View){
        val  querySearch = binding.etRepoName.text.toString()
        val queryLanguage = binding.etLanguage.text.toString()

        val intent = Intent(this@MainActivity, DisplayActivity::class.java)

        intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_REPO)
        intent.putExtra(Constants.KEY_REPO_SEARCH, querySearch)
        intent.putExtra(Constants.KEY_LANGUAGE, queryLanguage)

        startActivity(intent)

    }

    //search repos of a particular user and pass data to display Activity
    fun listUserRepositories(view: View){

        val userName = binding.etGithubUser.text.toString()

        val intent = Intent(this@MainActivity, DisplayActivity::class.java)

        intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_USER)
        intent.putExtra(Constants.KEY_GITHUB_USER, userName)

        startActivity(intent)

    }
}
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodal.DetailFactory
import com.example.myapplication.viewmodal.DetailViewModal
import com.example.myapplication.viewmodal.ResourceViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var model : DetailViewModal
    private lateinit var viewModelFactory : DetailFactory
    private lateinit var resourceModel : ResourceViewModel
    private val myClass:MyClass = MyClass(
        "Wait to input something...")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        //create model
        viewModelFactory = DetailFactory()
        model = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModal::class.java)
        //create resource api model
        resourceModel = ViewModelProviders.of(this).get(ResourceViewModel::class.java)
        //create nav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController, drawerLayout)
        navHostFragment.navController.addOnDestinationChangedListener{nc: NavController, nd: NavDestination, arg: Bundle? ->
            if(nd.id == nc.graph.startDestinationId){
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
            else drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
        Log.i("Architecture: ", "onCreate")

        resourceModel.callApi {  }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Architecture: ", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Architecture: ", "onRestart")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navControl = this.findNavController(R.id.fragmentContainerView)
        return NavigationUI.navigateUp(navControl, drawerLayout)
    }
}
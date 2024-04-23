package quanglong.ph27075.ghichueagle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import quanglong.ph27075.ghichueagle.databinding.ActivityMainBinding
import quanglong.ph27075.ghichueagle.frg.LoginFragment
import quanglong.ph27075.ghichueagle.frg.RegFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        binding.navigationView.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawers()
            when (it.itemId) {
                R.id.login -> {
                    replaceFragment(LoginFragment())
                }

                R.id.reg -> {
                    replaceFragment(RegFragment())

                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun replaceFragment(frg: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, frg).commit()
    }

}
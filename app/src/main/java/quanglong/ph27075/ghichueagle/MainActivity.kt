package quanglong.ph27075.ghichueagle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import quanglong.ph27075.ghichueagle.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      binding.navigationfrg.itemIconTintList = null
        binding.navigationfrg.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.login-> {

                    findNavController(R.id.navigationfrg).navigate(R.id.fragment_loginapp)

                    true
                }
                R.id.reg ->{

                    findNavController(R.id.navigationfrg).navigate(R.id.frgregapp)

                    true

                }

                else -> {

                    super.onOptionsItemSelected(it)

                }
            }
        }


    }




}
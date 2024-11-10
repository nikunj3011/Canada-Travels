package canadatravels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DiscoverActivity : AppCompatActivity() {
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    private var isDiscoveryCompleted:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sf = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE)
        editor = sf.edit()
        enableEdgeToEdge()
        setContentView(R.layout.activity_discover)
        if(sf.getBoolean("discoveryCompleted",false)){
            val intent = Intent(this@DiscoverActivity,HomeActivity::class.java)
            startActivity(intent)
        }
        val button: Button = findViewById<Button>(R.id.btnGoToHome)
        // Register the onClick listener with the implementation above
        button.setOnClickListener { view ->
            val intent = Intent(this@DiscoverActivity,HomeActivity::class.java)
            editor.apply{
                isDiscoveryCompleted = true
                putBoolean("discoveryCompleted", isDiscoveryCompleted)
                commit()
            }
            startActivity(intent)
        }
    }
}
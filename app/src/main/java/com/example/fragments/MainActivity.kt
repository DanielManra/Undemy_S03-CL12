package com.example.fragments

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    var LigthMode: Boolean= true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))



        //Carga de fragmento por defecto
        supportFragmentManager.beginTransaction()
            .add(R.id.contenedor, LigthModeFragment()).commit()
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            var fragment: Fragment? = null
            when {
                LigthMode -> {
                    fragment = LigthModeFragment()
                }else -> fragment = DarkModeFragment()
            }
            LigthMode = !LigthMode
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, fragment).commit()
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
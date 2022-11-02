package com.example.menu

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.View;
import android.widget.Button
import android.view.MenuItem;
import android.graphics.Color;

class MainActivity : AppCompatActivity() {
    lateinit var clickBtn: Button
    lateinit var layout: ConstraintLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         clickBtn= findViewById<Button>(R.id.clickBtn)
         layout = findViewById<ConstraintLayout>(R.id.layout)

        registerForContextMenu(clickBtn);

    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color")
        // add menu items
        menu.add(0, v.getId(), 0, "Yellow")
        menu.add(0, v.getId(), 0, "Gray")
        menu.add(0, v.getId(), 0, "Cyan")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.getTitle() === "Yellow") {
            layout.setBackgroundColor(Color.YELLOW)
        } else if (item.getTitle() === "Gray") {
            layout.setBackgroundColor(Color.GRAY)
        } else if (item.getTitle() === "Cyan") {
            layout.setBackgroundColor(Color.CYAN)
        }
        return true
    }
}
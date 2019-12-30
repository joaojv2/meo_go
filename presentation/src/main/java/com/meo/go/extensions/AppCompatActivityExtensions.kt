package com.meo.go.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


fun AppCompatActivity.setupToolbar(
    toolbar: Toolbar?,
    showHome: Boolean = true,
    title: String? = null
) {
    if (title != null) {
        setupToolbarWithTitle(toolbar, title, showHome)
    } else {
        setupToolbar(toolbar, showHome)
    }
}

private fun AppCompatActivity.setupToolbarWithTitle(
    toolbar: Toolbar?,
    title: String,
    showHome: Boolean
) {
    setSupportActionBar(toolbar)
    supportActionBar?.apply { ->
        toolbar?.title = title
        setSupportActionBar(toolbar)
        setDisplayHomeAsUpEnabled(showHome)
        setDisplayShowHomeEnabled(showHome)
    }
}
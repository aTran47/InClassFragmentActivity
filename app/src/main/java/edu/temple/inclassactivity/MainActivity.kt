package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    
    //lateinit var someVar : Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]


        // Attach an instance of ImageDisplayFragment using factory method
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ImageDisplayFragment

        val button = findViewById<Button>(R.id.button).setOnClickListener(){
            fragment.setImage(imageArray)
        }
        /*val fragment1 = ImageDisplayFragment.newInstance(imageArray)

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!is ImageDisplayFragment)
            supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,fragment1)
            .addToBackStack(null)
            .setReorderingAllowed(true)
            //.add(R.id.fragmentContainerView,ImageDisplayFragment.newInstance(imageArray))
            .commit()*/

    }
}
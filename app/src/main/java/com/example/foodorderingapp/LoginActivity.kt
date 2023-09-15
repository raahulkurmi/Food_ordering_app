package com.example.foodorderingapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.res.ResourcesCompat
import com.example.foodorderingapp.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class LoginActivity : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
binding.donthaveanaccount.setOnClickListener {
    donthaveacc()
}
val googleSignInOptions=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
googleSignInClient=GoogleSignIn.getClient(this,googleSignInOptions)

binding.button.setOnClickListener {
    if(binding.Emailorphone.text.toString().equals("")||binding.Loginpassword.text.toString().equals("")){
        Toast.makeText(this, "Enter credential", Toast.LENGTH_SHORT).show()

    }else {
        Firebase.auth.signInWithEmailAndPassword(
            binding.Emailorphone.text.toString(),
            binding.Loginpassword.text.toString()
        ).addOnCompleteListener {
            if(it.isSuccessful){
                startActivity(Intent(this,Locationactivity::class.java))


                MotionToast.createToast(this,
                    "Hurray success 😍",
                    "Login succesful!",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
            }else{
                MotionToast.createToast(this,
                    "Failed ☹️",
                    "Sigin Failed",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
            }
        }
    }


}

     binding.googlesignin.setOnClickListener {
         val intent=googleSignInClient.signInIntent
         if (intent != null) {
             Launcher.launch(intent)
         } else {
             Toast.makeText(this, "Google Sign-in Intent is null", Toast.LENGTH_SHORT).show()
         }
     }
        binding.linearLayout2.setOnClickListener {
            startActivity(Intent(this@LoginActivity,enterthenumber::class.java))
        }











    }

    private val Launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        if (result.resultCode== RESULT_OK){
            val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)
            if(task.isSuccessful){
                val account:GoogleSignInAccount?=task.result
                val credential=GoogleAuthProvider.getCredential(account?.idToken,null)
                Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                    if(it.isSuccessful){
                        MotionToast.createToast(this,
                            "Hurray success 😍",
                            "Google Login succesful!",
                            MotionToastStyle.SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
                        startActivity(Intent(this,Locationactivity::class.java))
                    }else{
                        MotionToast.createToast(this,
                            "Failed ☹️",
                            "Goole Login failed",
                            MotionToastStyle.ERROR,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.SHORT_DURATION,
                            ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))

                    }
                }
            }else{
                MotionToast.createToast(this,
                    "Failed ☹️",
                    "Google signin Cancelled",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
            }
        }
    }
   private fun donthaveacc(){
       startActivity(Intent(this,Signup::class.java))

   }
}
package com.example.contacts


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.contacts.databinding.ActivityBottomSheetBinding
import com.example.contacts.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContactActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var textViewNoContact: TextView
    private lateinit var fab: FloatingActionButton
    val contacts: MutableList<ItemContact> = mutableListOf() // قائمة مهيأة
    private lateinit var adapter: ContactAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        //    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializationWidget()

        // تهيئة العناصر
        initRecycler()
    }

//    private fun createTestContact() {
////        // إضافة بيانات تجريبية إلى القائمة
//
//
//        for (i in 1..8) {
//            contacts.add(
//                ItemContact(
//                    "userName",
//                    "userEmail",
//                    "userPhone"
//                )
//            )
//        }
//
//    }

    private fun updateUI() {
        // تحديث الـ UI بناءً على وجود بيانات في القائمة
        if (contacts.isEmpty()) {
            lottieAnimationView.visibility = View.VISIBLE
            textViewNoContact.visibility = View.VISIBLE
        } else {
            lottieAnimationView.visibility = View.GONE
            textViewNoContact.visibility = View.GONE
        }
    }

    private fun initializationWidget() {

        lottieAnimationView = findViewById(R.id.https_lotti)
        textViewNoContact = findViewById(R.id.tv_no_contact)
        recyclerView = findViewById(R.id.recycler_view) // يجب أن يتطابق ID مع XML
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {

        //    updateUserDetails(binding1.nameContact.toString(),binding1.nameEmail.toString(),binding1.nameNumber.toString())

        adapter = ContactAdapter(contacts)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // عرض عنصرين في كل صف
        binding.recyclerView.adapter = adapter
        adapter.setContactList(contacts)
        adapter.onDeleteClick = ContactAdapter.OnImageRemoveListener { position, contact ->
            adapter.deleteContact(position, contact)
            updateUI()

        }
        adapter.notifyDataSetChanged()



        updateUI()


        binding.fab.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetBinding = ActivityBottomSheetBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)
            bottomSheetDialog.show()
            bottomSheetBinding.buttonEnter.setOnClickListener {
                val userName = bottomSheetBinding.tiUserName.editText?.text?.trim().toString()
                val userEmail = bottomSheetBinding.tiUserEmail.editText?.text.toString().trim()
                val userPhone = bottomSheetBinding.tiUserPhone.editText?.text.toString().trim()
                if (!validateTextField(bottomSheetBinding)) {
                    return@setOnClickListener
                }
                val contact = ItemContact(
                    name = userName,
                    emailName = userEmail,
                    phoneNumber = userPhone,
                )
                adapter.addContact(contact)
                updateUI()
                bottomSheetDialog.dismiss()
            }
//            val bottomSheet = MyBottomSheetDialog()
//            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }


    }

    private fun validateTextField(bind: ActivityBottomSheetBinding): Boolean {
        val userName = bind.tiUserName.editText?.text?.trim().toString()
        val userEmail = bind.tiUserEmail.editText?.text.toString().trim()
        val userPhone = bind.tiUserPhone.editText?.text.toString().trim()
        val nameError = Validate.validateName(userName)
        val emailError = Validate.validateEmail(userEmail)
        val phoneError = Validate.validatePhone(userPhone)

        bind.tiUserName.error = nameError
        bind.tiUserEmail.error = emailError
        bind.tiUserPhone.error = phoneError
        return nameError == null && emailError == null && phoneError == null
    }

//    fun updateUserDetails(name: String, email: String, phone: String) {
//        binding1.nameContact.text = name
//        binding1.nameEmail.text = email
//        binding1.nameNumber.text = phone
//        binding1.cardContact.visibility = View.VISIBLE
//    }

}

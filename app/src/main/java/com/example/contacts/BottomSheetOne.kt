//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import com.example.contacts.R
//import com.example.contacts.databinding.ActivityBottomSheetBinding
//import com.example.contacts.databinding.ActivityMainBinding
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//import com.google.android.material.textfield.TextInputEditText
//
//class MyBottomSheetDialog : BottomSheetDialogFragment() {
//
//    lateinit var enterButton: Button
//    lateinit var textInputName : TextInputEditText
//    lateinit var textInputEmail : TextInputEditText
//    lateinit var textInputPhone : TextInputEditText
//    lateinit var userNameTitle : TextView
//    lateinit var userEmailTitle : TextView
//    lateinit var userPhoneTitle : TextView
//    lateinit var viewBinding: ActivityBottomSheetBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this bottom sheet
//        return viewBinding.root
////inflater.inflate(R.layout.activity_bottom_sheet, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        viewBinding.buttonEnter.setOnClickListener {
//            // get my data
//            val userName = textInputName.text.toString().trim()
//            val userEmail = textInputEmail.text.toString().trim()
//            val userPhone = textInputPhone.text.toString().trim()
//            //   contacts.add(ItemContact(userName,userEmail,userPhone))
//
//            userNameTitle.text = userName
//            userEmailTitle.text = userEmail
//            userPhoneTitle.text = userPhone
//        }
//    }
//}
//
//
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contacts.ContactAdapter
import com.example.contacts.ItemContact
import com.example.contacts.databinding.ActivityBottomSheetBinding
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.databinding.CardItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialog : BottomSheetDialogFragment() {

    lateinit var binding: ActivityBottomSheetBinding
    lateinit var bindingCard: CardItemBinding
    lateinit var bindingMain: ActivityMainBinding
    private lateinit var adapter: ContactAdapter


//    private var _binding: ActivityBottomSheetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // التعامل مع العناصر عبر الـ Binding
        val contacts: MutableList<ItemContact> = mutableListOf() // قائمة مهيأة

        binding.buttonEnter.setOnClickListener {


            return@setOnClickListener
            val userName = binding.tiUserName.editText?.text.toString().trim()
//            val userEmail = binding.tiUserEmail.editText?.text.toString().trim()
//            val userPhone = binding.tiUserPhone.editText?.text.toString().trim()
//
//            if (userName.isNotEmpty()&& userEmail.isNotEmpty() && userPhone.isNotEmpty()) {
//                bindingCard.nameContact.text = userName
//                bindingCard.nameEmail.text = userEmail
//                bindingCard.nameNumber.text = userPhone
//                contacts.add(ItemContact(bindingCard.nameContact.toString(),bindingCard.nameEmail.toString(),bindingCard.nameNumber.toString()))
//
//                adapter = ContactAdapter(contacts)
//                bindingMain.recyclerView.adapter = adapter
//                adapter.notifyDataSetChanged()
//            } else {
//                Toast.makeText(requireContext(), "Please enter a user name", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }
            //   contacts.add(ItemContact(userName,userEmail,userPhone))


            dismiss() // إغلاق الـ BottomSheet بعد إضافة البيانات
        }
    }


}

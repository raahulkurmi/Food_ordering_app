package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.menuadapterrecycler
import com.example.foodorderingapp.databinding.FragmentHomeBinding
import com.example.foodorderingapp.modelclass.Recyclerviewmodelclas
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class homeFragment : Fragment() {
    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    val itemlist = ArrayList<Recyclerviewmodelclas>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner1,"Burger","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner2,"Chicken burger","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner3,"Steak chicken","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner4,"Americano","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner5,"Vodka","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner7,"Whisky","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner8,"tequila","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner,"pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner1,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner2,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner3,"Herbal pancake","$7"))
        itemlist.add(Recyclerviewmodelclas(R.drawable.banner4,"Herbal pancake","$7"))

        binding.recyclerview.layoutManager= LinearLayoutManager(requireContext())
        val adaptor=menuadapterrecycler(itemlist)
        binding.recyclerview.adapter=adaptor
        binding.recyclerview.setHasFixedSize(true)

//
//        var bottomsheetdialog : BottomSheetDialogFragment =withdrawalfragment()
//        bottomsheetdialog.show(requireActivity().supportFragmentManager,"test")
//        bottomsheetdialog.enterTransition


        binding.textView18.setOnClickListener {
            val bottomSheetDialog=bottomsheetfoodmenu()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"test")
            bottomSheetDialog.enterTransition
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>() // Create image list



        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner5,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner6, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner7, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner8,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner8, ScaleTypes.FIT))
        binding.imageSlider.setImageList(imageList)

        binding.imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val postion=imageList[position]
                val message="item selected " + "$position"
                MotionToast.createToast(requireActivity(),
                    "YOUR️ CHOICE",
                    message,
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helveticabold))
            }

        })

    }




}
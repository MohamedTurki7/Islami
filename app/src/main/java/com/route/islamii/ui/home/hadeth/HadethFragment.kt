package com.route.islamii.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamii.databinding.FragmentHadethBinding
import com.route.islamii.ui.hadeatDetails.HadethDetailsActivity

class HadethFragment : Fragment() {
    companion object {
        const val HADETH = "hadeth"
    }

    lateinit var binding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHadethBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethContent()
    }

    private fun readHadethContent() {
        val allHadethList: MutableList<Hadeth> = mutableListOf()
        val allFileContent = requireContext().assets.open("ahadeth.txt")
            .bufferedReader().use { it.readText() }
        val separatedAhadethContent = allFileContent.split("#")
        separatedAhadethContent.forEach { hadeth ->
            val hadethLines = hadeth.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            hadethLines.removeAt(0)
            val h = Hadeth(title = title, content = hadethLines.joinToString("\n"))
            allHadethList.add(h)

        }
        bindHadethList(allHadethList)


    }

    private fun bindHadethList(allHadethList: MutableList<Hadeth>) {
        val hadethRecyclerAdapter = HadethRecyclerAdapter(allHadethList)
        hadethRecyclerAdapter.onItemClickListener =
            HadethRecyclerAdapter.OnItemClickListener { position, hadeth ->
                startHadethDetailsActivity(hadeth)
            }


        binding.chaptersRecycler.adapter = hadethRecyclerAdapter

    }

    private fun startHadethDetailsActivity(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(HADETH, hadeth)
        startActivity(intent)




    }
}

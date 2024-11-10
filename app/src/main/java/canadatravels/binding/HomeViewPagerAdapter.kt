package canadatravels.binding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import canadatravels.ui.character.CharacterFragment
import canadatravels.ui.bangboos.BangbooFragment
import canadatravels.ui.homedata.HomeDataFragment
import canadatravels.ui.wengines.WEngineFragment

class HomeViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeDataFragment()
            1 -> CharacterFragment()
            2 -> BangbooFragment()
            3 -> WEngineFragment()
            else -> CharacterFragment()
        }
    }

}
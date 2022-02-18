package org.techtown.navigation_test.DataModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * 원래 Livedata는 값 변경을 할 수 없지만 MutableLiveData는 값변경을 .value 로 할 수 있다.
 * 여기서는 livedata를 두개 설정해서 하나는 내부에서 값을 변경하게 하고
 * 하나는 외부에서 값을 가져갈 수 있게 하는데 직접적으로 가져가는것이 아닌 ViewModel을 통해서 가져갈 수 있게 하였다.
 */

enum class SetEvent {
    PLUS, MINUS
}

//뷰모델은 라이브 데이터를 가지고 있음.
class NoteViewModel : ViewModel() {

    private val TAG : String = "NoteViewModel 로그"

    //내부에서 변경 가능한 데이터러를 설정 (하지만 외부에서는 직접적으로 변경할 수 없음.)
    private val _currentCount = MutableLiveData<Int>()

    //이제 외부에서 꺼내갈 수 있는 live data를 만들어 주어야함.
    val currentCount : LiveData<Int> get() = _currentCount

    //MutableLiveData의 초기값이 없기때문에 초기값을 설정해 주어야 한다.
    init {
        Log.d(TAG, "init MutableLivedata 생성자 호출")

        //MutableLivedata의 값으로 접근하려면  .value를 사용
        _currentCount.value = 0
    }

    //뷰 모델이 가지고 있는 livedata 의 값을 변경하는 메서드
    fun updateCount(event : SetEvent) {
        when(event) {
            SetEvent.PLUS -> {
                _currentCount.value = _currentCount.value?.plus(1)
            }
            SetEvent.MINUS -> {
                _currentCount.value = _currentCount.value?.minus(1)
            }

        }
    }


}































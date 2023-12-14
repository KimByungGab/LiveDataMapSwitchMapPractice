LiveData를 사용할 때 기존에 LiveData를 Observe 형태로 사용하는 경우도 있지만 만약 하나의 값에 여러개가 동시에 바뀌게 되는 경우라면 처리해야 할 코드도 점점 늘어나기 마련이다.

때문에 값의 변경을 액티비티나 프래그먼트단에서 하면 바뀌는 코드가 늘어나면 늘어날수록 코드도 커지게 되기 때문에 ViewModel에서 바꾸고 싶게 될 때가 있다.

그렇게 좀 더 유연하게 사용할 수 있는 게 LiveData core에서 제공해주는 Transformation의 map과 switchMap이다.

둘은 기본적으로 Javascript의 map이나 Java 람다함수의 map을 생각하면 편하다.

하지만 둘의 차이는 return하는 LiveData 인스턴스의 전환이라고 생각하면 된다.

간단하게 map은 단지 현재 사용하고있는 LiveData 인스턴스의 데이터만 변경한다.
하지만 switchMap은 데이터를 이용하여 다른 LiveData로 전환을 할 수 있다.

때문에 switchMap을 사용할 때는 주로 비동기 작업에서 새로운 LiveData의 결과값에 따라 데이터 소스를 변경하고 싶을 때 사용한다.
대표적으로 Repository에서 가져온 값을 사용할 경우가 대표적인 예이다.

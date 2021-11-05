package test.mypac;

// @xxx 는 어노테이션(장식자) 라고 부른다.
// @FunctionalInterface 는 메소드를 하나만 정의 하도록 강제한다.
@FunctionalInterface
public interface Drill {
	
    public void hole();

   
}
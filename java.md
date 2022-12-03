# 자료 구조
- 분류
  - 선형 자료구조
  - 비선형 자료구조
  - 집합 자료구조

## 선형 자료구조
- 데이터가 일렬로 연결된 형태
- int[] 배열 같은 것
- 종류 : List, Queue, Deque

## 비선형 자료구조
- 각 요소가 여러개의 요소와 연결 된 형태를 생각하면 된다.
- 종류 : Graph, Tree

## 집합 자료구조
- 데이터가 연결 된 형식이 아니고, table에 가까운 자료구조

### List interface
- 동적 크기를 갖으면서 배열처럼 사용할 수 있음
- 현재 제일 많이 써본 애
- List interface를 구현하는 클래스
    1. ArrayList
    2. LinkedList
    3. Vector
- List interface에 선언된 대표적 메소드
  - add
  - remove
  - contains
  - size
  - get
  - set
  - isEmpty
  - equals
  - indexOf
  - clear

#### ArrayList
- Object[] 배열을 사용하면서 내부 구현을 통해 동적으로 관리
- 중간의 요소가 삽입, 삭제가 일어나는 경우, 그 뒤의 요소들을 한 칸씩 밀거나 당겨야 하기 때문에 삽입, 삭제에서는 비효율적 모습
- `ArrayList<T> arraylist = new ArrayList<>();`

#### LinkedList
- 데이터와 주소로 이루어진 클래스를 만들어 서로 연결하는 방식이다
- 데이터+주소인 클래스를 노드 라고 정의
- 노드는 이전의 노드와 다음 노드를 연결하는 방식이다.
- 검색해야하는 경우 연결된 모든 노드들을 방문해야해서 성능이 떨어지지만
- 노드를 삭제, 추가 할 경우 해당 노드의 링크를 끊거나 연결만 해주면 되기 때문에 매우 효율적 모습을 나타낸다
- `LinkedList<T> linkedlist = new LinkedList<>();`

#### Vector
- 기본적인것은 ArrayList와 같다
- 동기적으로 움직이다보니 멀티쓰레드에서 안전하지만 ArrayList에 비해 성능이 약간 느리다
- `Vector<T> vector = new Vector<>();`

#### Stack
- 후입선출의 LIFO
- `Stack<T> stack = new Stack<>();`

### Queue interface
- 선입선출의 FIFO
- 스택과 많이 비교를 함 (FIFO vs LIFO)
- Queue를 구현하는 클래스
  1. *LinkedList*
  2. ArrayDeque
  3. PriorityQueue
- Queue에 선언된 대표적인 메소드
  - add
  - offer   
  - peek
  - poll
  - addLast
  - addFirst
  - offerLast
  - offerFirst
  - peekFirst
  - peekLast
  - pollFirst
  - pollLast
  - size

#### LinkedList
- 여기서 LinkedList의 특징이 나온다
- List, Deque, Queue 3가지 용도로 사용가능
- 일반적인 Queue를 사용하려면 LinkedList로 생성을 하여 선언해야함
- `Queue<T> linkedlistdeque = new LinkedList<>();`
- `Deque<T> linkedlistdeque = new LinkedList<>();`

#### PriorityQueue
- 우선순위 큐
- 데이터의 우선순위를 기반하여 우선순위가 높은 데이터가 선출되는 원리
- 따로 정렬방식을 지정하지 않으면 낮은 숫자가 높은 우선순위를 갖음
- 사용자가 정의한 객체를 타입으로 쓸 경우 반드시 Comparator/Comparable을 통해 정렬 방식을 구현해야함
- `PriorityQueue<T> priorityqueue = new PriorityQueue<>();`
- `Queue<T> priorityqueue = new PriorityQueue<>();`

### Set
- 데이터 중복저장 불가
- 입력 순서대로 저장 순서를 보장 불가
- 
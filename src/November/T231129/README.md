# Collection Framework

- Iterable - Collection - Map, Set, List

---

# List

- 순서가 있는 데이터
- 중복 허용
- 원소를 일렬로 세워 추가, 제거, 조회 등을 위해 활용
- List는 interface → type List로 선언

<aside>
💡 List<Integer> list = new ArrayList<>();

</aside>

```java
        ArrayList<Integer> intArrayList = new ArrayList<>();
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        sum(intArrayList);
        sum(intLinkedList);
    }

    // 매개변수를 전달하는 기능을 중시하는 interface 기준으로 매개변수 선언
    public static int sum(List<Integer> intList) {
        return 0;
    }

    // 구현을 중시하는 방식으로 요구를 하면 기능적 측면의 차이가 없는 클래스는 사용 불가
    public static int sum(ArrayList<Integer> intList) {
        return 0;
    }
```

### ArrayList

- 동적으로 배열의 크기 바꿔가며 활용
- 임의의 위치에서 원소 가져오기에 용이
1. ArrayList생성

```java
// ArrayList: 배열을 관리해주는 Collection - List
        List<String> names = new ArrayList<>();
```

- 인터페이스를 기준으로 코드 작성
1. 데이터 추가

```java
// 리스트에 넣기
        names.add("Alex");
        names.add("Brad");
        names.add("Dave");
        names.add("Eric");
```

1. 데이터 회수

```java
			System.out.println(names.get(0));
      System.out.println(names.get(2));
```

1. 중간에 넣기

```java
	      names.add(2, "Chad");
        System.out.println(names);
        names.add("Fred");
```

1. 데이터 제거

```java
        System.out.println(names.remove(3)); // 순서를 기준으로
        System.out.println(names.remove("Eric")); // 값을 기준으로
        System.out.println(names.remove("Eric")); // 값을 기준으로 찾는데 실패
```

1. 데이터 찾기

```java
        // 데이터 위치 찾기
        System.out.println("Chad is at: "+names.indexOf("Chad"));
        // 없을 경우 -1
        System.out.println("Grad is at: "+names.indexOf("Grad"));
```

### LinkedList

- 연결리스트 형태로 데이터 관리
- 원소 추가, 제거에 유리

---

## Set

- 중복 허용
- Hash Table
    - Hash Code 사용해 구분
- Hash Set
    - 중복 허용, 중복되는 데이터 추가되지 않음
    - 데이터의 순서를 보장하지 않음

```java
        Set<String> skilSet =new HashSet<>();
        // add를 사용해 원소 추가하는 것 동일
        skilSet.add("md");
        skilSet.add("git");
        skilSet.add("java");
        skilSet.add("oop");
        // 중복되는 데이터는 추가 X
        skilSet.add("java");
        // 데이터의 순서를 보장하지 않음
        System.out.println(skilSet);
```

- addAll()
    - 다른 Collection의 원소를 전부 추가 시도
    - 없는 원소를 선별해 추가
    - 하나라도 추가되면 return true

```java
  // 다른 Collection의 원소를 전부 추가 시도
        // 내가 없는 원소를 선발해 추가한다
        // 하나라도 추가하면 true
        System.out.println(skillList); // true
        System.out.println(skilSet.addAll(skillList));
        System.out.println(skilSet);
```

---

# Iterable & Collection

- List와 Set의 기초가 되는 인터페이스

## Iterable

- 반복 가능하다
- Iterator 객체 활용해 데이터 확인 가능
- List와 Set 모두 Iterable로 서로 바꾸는 것이 가능하다
- 순서를 보장하지는 않음
- hasNext()
    - 다음에 데이터가 존재하는지 확인
    - return boolen
- next()
    - Iterator가 이동하면서 다음에 있는 데이터 반환
    - return T
- remove()
    - for-each를 이용한 데이터 제거 불가(예외발생 `ConcurrentModificationException`)
    - remove()를 사용해 안전하게 순회 중 제거가 가능하게 함

```java
// Iterator
        Iterator<String> iter = skillList.iterator();
        // 다음 대상이 있는지 판단
        while (iter.hasNext()) {
            // next()를 이용해 다음에 있는 data 가져옴
            String skill = iter.next();
            System.out.println(skill);
            // iter.remove()를 사용하면 안전하게 순회 중 제거 가능
            if ("python".equals(skill))
                iter.remove();
        }
        System.out.println(skillList);
```

## Collection

- Collection 인터페이스를 구현하는 하위 항목을 만족하는 클래스를 만들어야 함
    1. 아무것도 없는 기본 생성자
    2. 다른 Collection을 받아 그 모든 원소를 가지는 생성자

---

# Map

- Key - Value 쌍으로 구성되어 있음
- 순서 중요하지 않음
- ex)
    - 핸드폰 - 연락처
    - 이름 - 전화번호
    - 메뉴 - 가격

- put()
    - map에 원하는 Key - Value 값 저장 가능
        - Map에 연락처 저장

```java
        Map<String, String> contactBook = new HashMap<>();
        // Map에 연락처 저장
        contactBook.put("Alex", "010-1234-5678");
        contactBook.put("Brad", "010-9876-5432");
        contactBook.put("Chad", "010-0110-0000");
        contactBook.put("Eric", "010-2222-2222");
```

- get()
    - map에 저장된 Key값을 바탕으로 Value값 가져옴
        - Map에서 연락처 찾아오기

```java
// Map에서 연락처 찾아오기
        System.out.println(contactBook.get("Alex"));
        System.out.println(contactBook.get("Chad"));
        System.out.println(contactBook.get("Brad"));
        // 1. 없는걸 가져올때는 null이 된다
        System.out.println(contactBook.get("Dave"));
        // 2. 있는걸 추가할때는 덮어씌운다
        contactBook.put("Eric", "010-2555-5555");
```

- putIfAbsent()
    - 만약 데이터를 넣어야 하는 상황에 새로운 값이 추가된다면
    - 지정된 키가 아직 값과 연결되지 않은 경우(또는 null에 매핑된 경우)

    ```java
            Integer before = majorMember.putIfAbsent(newMajor, 1);
            if (before != null) {
                majorMember.put(newMajor, before+1);
            }
    ```

    - if - else 이용

        ```java
        // 1. majorMember.get("major") == null
                String newMajor = "ENG";
                if (majorMember.get(newMajor) == null) {
                    majorMember.put(newMajor, 1);
                } else {
                    int before = majorMember.get(newMajor);
                    majorMember.put(newMajor, before+1);
                }
        ```


<aside>
💡 Map을 순회하고 싶은 경우 → KeySet(), entrySet() 이용

</aside>

- KeySet()

```java
// 이름을 기준으로 연락처를 가지고 오는 것 선택 가능
        Set<String> KeySet = contactBook.keySet();
        for (String key : contactBook.keySet()) {
            System.out.println(key);
            // Key로만 구성되어있는 집합 불러옴
            System.out.println(contactBook.get(key));
        }
```

- entrySet()
    - Key - Value 쌍으로 구성된 Set

```java
        for (Map.Entry<String, String> entry : contactBook.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
```
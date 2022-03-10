package CodingTest;

/**
 * 문제 설명
 * EMPLOYEE_RELATIONSHIPS 테이블은 회사 직원 간의 위계 관계를 나타내는 테이블입니다. EMPLOYEE_RELATIONSHIPS 테이블 구조는 다음과 같으며, NAME은 직원의 이름, BOSS는 상관의 이름입니다.
 *
 * NAME	TYPE	NULLABLE
 * NAME	VARCHAR(N)	FALSE
 * BOSS	VARCHAR(N)	TRUE
 * 문제
 * 사원은 상관의 유무에 따라서 3가지 유형으로 나뉩니다.
 *
 * 상관이 없는 직원(BOSS가 NULL)은 이 회사의 "CEO"입니다.
 * CEO가 아닌 직원 중, 본인이 누군가의 상관인 경우는 "MANAGER"입니다.
 * 1이나 2에 해당하지 않은 직원은 "WORKER"입니다.
 * 모든 사원의 이름과 이 사원의 유형을 조회하는 SQL 문을 작성해주세요. 이때 사원 이름은 알파벳 순으로 나열되어야 합니다.
 *
 * 예시
 * 예를 들어 EMPLOYEE_RELATIONSHIPS 테이블이 다음과 같은 경우
 *
 * NAME	BOSS
 * Ava
 * Emily	Ava
 * Emma	Emily
 * Liam	Ava
 * SQL을 실행하면 다음과 같이 출력되어야 합니다.
 *
 * NAME	BOSS
 * Ava	CEO
 * Emily	MANAGER
 * Emma	WORKER
 * Liam	WORKER
 */
public class Trenbe04 {
    public static void main(String[] args) {

    }
}

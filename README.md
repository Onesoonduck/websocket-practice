# websocket-practice


# elice WebSocket Project Practice

# 진행 상황 
1. 간단한 책 주문 프로세스 개발 -> 개발 완료
2. 주문 비즈니스 로직 - 재고 확인 -> 개발 완료
3. 재고가 없거나 적으면 예외 발생 (커스텀 예외클래스를 추가) -> 개발 완료, 리팩토링 필요
4. 발생한 예외는 AOP를 활용하여 처리 -> 개발 완료

# TODO
1. WebSocket과 Spring stomp를 활용해 "주문 이슈 관리" 채팅방 구현
2. 예외가 발생하면 "주문 이슈 관리" 채팅방에 에러 메시지를 전송

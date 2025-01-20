$(function () {
	init();   // init()은 초기화 데이터를 뿌리는 작업을 함(?)
	$('#regist').on('click', appendCustomer);
	
	// checkAll 를 선택하면 데이터가 모두 선택 또는 모두 선택해제
	$('#checkAll').on('click', function() {
		if($(this).is(":checked")) {
			$('tbody input[type=checkbox]').prop('checked', true);
		} else {
			$('tbody input[type=checkbox]').prop('checked', false);
		}
	})
});

// 초기화 함수
function init() {
	// 서버에서 데이터를 수신했다고 가정
	let receivedData = [
		{"name": "홍길동", "phone": "010-1111-2222", "gender":"남성", "addr":"서울시 동작구"}
		, {"name": "전우치", "phone": "010-2222-33333", "gender":"남성", "addr":"강서구"}
		, {"name": "심청", "phone": "010-11212", "gender":"여성", "addr":"남원"}
		, {"name": "이몽룡", "phone": "010-3535", "gender":"남성", "addr":"서울시 종로구"}
		, {"name": "김방자", "phone": "010-1200", "gender":"남성", "addr":"전라도 광주"}
	];
	
	// receivedData 변수는 서버에서 수신한 고객 정보의 배열. 각 고객 정보는 객체 형태로 저장.
	// $.each(receivedData, function(index, data) // 아래코드와 동일한 표현
	$(receivedData).each(function(index, data){ //  jQuery의 each 메서드는 배열이나 객체의 각 요소에 대해 반복 작업을 수행할 수 있게 해줌.
		let name = data['name'];				// data는 현재 반복에서 처리하고 있는 고객 정보 객체.
		let phone= data['phone'];
		let gender= data['gender'];
		let addr= data['addr'];
		
		output(name, phone, gender, addr); 
		// output 함수 호출: 
		// 위에서 가져온 name, phone, gender, addr 값을 인자로 받아, 고객 정보를 HTML 테이블에 추가해줌.
		// output 함수는 각 고객 정보를 화면에 표시하기 위해 HTML 요소를 생성하고, 이를 결과 테이블에 추가함.
	}); // end each() 
}	
// 값을 태그로 만든 후 화면에 출력
function output(name, phone, gender, addr) {
	let tag = `
		<tbody>
			<tr>
				<td><input type="checkbox"></td>
				<td>${name}</td>
				<td>${phone}</td>
				<td>${gender}</td>
				<td>${addr}</td>
				<td><input type="button" value="삭제" class="deleteBtn"></td>
			</tr>
		</tbody>
	`;
	
	$('#result table').append(tag);
	$('.deleteBtn').on('click', deleteItem);  // 위치, 순서 중요
} 
function appendCustomer() {
	let name = $('#name').val();
	let phone = $('#phone').val();
	let gender = $('input[type=radio]:checked').val();
	let addr = $('#addr').val();
	
	output(name, phone, gender, addr);
}

function deleteItem(event) {  // event: 브라우저가 자동으로 전달하는 event 객체
	let name = $(this).parent().parent().children(':nth-child(2)').text(); // 두 번의 parent() 호출을 통해 삭제 버튼이 포함된 <td> 요소의 부모인 <tr> 요소를 선택. 즉, 삭제 버튼이 속한 행을 선택
	let isDelete = confirm(name+' 님을 삭제하시겠습니까?');
	if(isDelete) {
		$(this).parent().parent().remove();
		event.stopImmediatePropagation();    // 이벤트 버블링을 멈춤
	}
}
$(document).ready( function() {

    // 섹션 분리
    $("#header").load("./web/header.html");
    $("#main").load("./web/main.html");
    $("#footer").load("./web/footer.html");

    // 모달창 회전
    carousel();
});

function carousel(){
    $('.owl-carousel').owlCarousel({
        loop:false,
        margin:10,
        nav:true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:1
            },
            1000:{
                items:2
            }
        }
    });
}

var modal = document.getElementById('myModal');
var span = document.getElementsByClassName("close")[0];

function modalOpen(num){
    modal.style.display = "block";
    var title = document.getElementsByClassName('box_title')[num].innerText;
    var content = document.getElementsByClassName('box_content')[num].innerText;
    var src = document.getElementsByClassName('project_img')[num].getAttribute('src');
    var page = document.getElementsByClassName('page')[num].getAttribute('href');
    var repo = document.getElementsByClassName('page')[num].getAttribute('href');

    // 타이틀, 텍스트 내용, 이미지 경로 및 크기 지정
    document.getElementById('modal_title').innerText=title;
    document.getElementById('modal_text').innerText=content;
    document.getElementById('modal_img').src=src;
    document.getElementById('modal_img').style.height='340px';
    document.getElementById('modal_page').href = page;
    document.getElementById('modal_repo').href = repo;

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

function modalClose(){
    modal.style.display = "none";
}
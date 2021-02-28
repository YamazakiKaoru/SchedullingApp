$(function () {
  $('#openModal').click(function(){
  console.log("called");
      $('#modalArea').fadeIn();
  });
  $('#closeModal , #modalBg').click(function(){
    $('#modalArea').fadeOut();
  });
});
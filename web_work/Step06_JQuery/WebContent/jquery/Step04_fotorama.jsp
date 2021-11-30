<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step04_fotorama.jsp</title>
<link  href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
<style>
   .content{
      width: 800px;
      height: 500px;
      background-color: yellow;
   }
   .content img{
      width: 100px;
   }
</style>
</head>
<body>
   <div class="fotorama"
      data-width="500"
      data-height="300"
      data-allowfullscreen="true"
      data-nav="thumbs"
      data-autoplay="true">
      <img src="images/image1.png" data-caption="하나"/>
      <img src="images/image2.png" data-caption="두울"/>
      <img src="images/image3.png" data-caption="세엣"/>
      <img src="images/image4.png" data-caption="네엣"/>
      <img src="images/image5.png" data-caption="다섯"/>
   </div>
   
   <div class="fotorama">
      <div class="content">
         <h3>첫번째 컨텐츠</h3>
         <img src="images/1.jpg" alt="" />
         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque hic voluptate magni doloremque consectetur magnam fuga possimus aspernatur quam dolorum nostrum sequi facilis vitae ducimus natus nobis provident praesentium! Aspernatur.</p>
      </div>
      <div class="content">
         <h3>두번째 컨텐츠</h3>
         <img src="images/2.jpg" alt="" />
         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque hic voluptate magni doloremque consectetur magnam fuga possimus aspernatur quam dolorum nostrum sequi facilis vitae ducimus natus nobis provident praesentium! Aspernatur.</p>
      </div>
      <div class="content">
         <h3>세번째 컨텐츠</h3>
         <img src="images/3.jpg" alt="" />
         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque hic voluptate magni doloremque consectetur magnam fuga possimus aspernatur quam dolorum nostrum sequi facilis vitae ducimus natus nobis provident praesentium! Aspernatur.</p>
      </div>
   </div>
</body>
</html>








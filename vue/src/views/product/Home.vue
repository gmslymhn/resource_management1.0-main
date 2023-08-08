<template>
  <div class="home">
    <!-- <section id="sec">
        <div><img src="@/assets/1.jpg" alt=""></div>
        <div><img src="@/assets/2.jpg" alt=""></div>
        <div><img src="@/assets/3.jpg" alt=""></div>
        <div><img src="@/assets/4.jpg" alt=""></div>
        <div><img src="@/assets/5.jpg" alt=""></div>
        <div><img src="@/assets/6.jpg" alt=""></div>
        <div class="tyut">Welcome to ReManage</div>
    </section> -->
    <div id="selab"><img src="@/assets/selab.png"></div>
    <div class="title">
      <p>Welcome to ReManage</p>
      <p>年轻人的次世代资源管理系统</p>
    </div>
  </div>
</template>

<script>
import getMessageQuantity from "@/utils/getMessageQuantity";
export default {
  name: 'Content-Home',

  data() {
    return {
      
    };
  },

  created() {
    this.$store.dispatch("style/setContent2Style","background-color: transparent !important")
  },
  mounted() {
    if(this.$store.state.login.role === "admin"){
      getMessageQuantity(this)
    }
  },
  beforeDestroy() {
    this.$store.dispatch("style/clearContent2Style")
  },
};
</script>

<style scoped>
@font-face {
    font-family:AaBlack;
    src:url('@/assets/font/ttf/Aa厚底黑.ttf')
  }
.home{
    background-color: transparent !important;
    width: 100%;
    height: calc( 100vh - 80px );
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
#selab{
  max-width: 40%;
  margin-top: 30px;
  margin-left: 30px;
  /* height: 30%; */
}
#selab img{
  width: 100%;
  object-fit: contain;
}
.title{
  font-family: "AaBlack";
  margin-bottom: 50px;
  margin-left: 50px;
  font-size: 4.5em;
  line-height: 2;
  font-style: italic;
  color: #ec9bad;

  cursor: pointer;
  text-shadow:
    1px 2px 0px #b37fb8,
    2px 3px 0px #b17cae,
    3px 4px 0px #8f6c92,
    4px 5px 0px #976d8d,
    5px 6px 10px rgba(231, 126, 209, 0.6);
}

/* #sec{
    position: absolute;
    top: 390px;
}
section {
    position: absolute;
    left: 32%;
    width: 300px;
    height: 200px;
    cursor: pointer; */
    /* 很关键，preserve-3d是物体看起来有3d效果 */
    /* transform-style: preserve-3d;
    animation: rotate 20s linear infinite; */
/* }
.tyut{
    position: absolute;
    color: white;
    top: -150px;
    font-size: 50px;
    font-family: '华文琥珀';
}
section:hover{
    animation-play-state: paused;
}
section div {
    text-align: center;
    position: absolute;
    width: 100%;
    height: 100%; */
    /* 用来实现倒影效果 */
    /* -webkit-box-reflect:bottom 15px
    -webkit-linear-gradient(transparent 10%,rgba(255,255,255,.3));
}           

section div img {
    width: 300px;
    height: 200px;
} */

/* section div:nth-child(1) {
    transform: translateZ(300px);
} */

/* section div:nth-child(2) {
    transform: rotateY(60deg) translateZ(300px);
}

section div:nth-child(3) {
    transform: rotateY(120deg) translateZ(300px);
}

section div:nth-child(4) {
    transform: rotateY(180deg) translateZ(300px);
}

section div:nth-child(5) {
    transform: rotateY(240deg) translateZ(300px);
}

section div:nth-child(6) {
    transform: rotateY(300deg) translateZ(300px);
} */
/* @keyframes rotate{
    0%{
        transform: rotateY(0);
    }
    100%{
        transform: rotateY(360deg);
    }
} */
</style>
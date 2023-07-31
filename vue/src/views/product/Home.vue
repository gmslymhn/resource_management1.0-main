<template>
  <div class="main">
    <section>
        <div><img src="@/assets/1.jpg" alt=""></div>
        <div><img src="@/assets/2.jpg" alt=""></div>
        <div><img src="@/assets/3.jpg" alt=""></div>
        <div><img src="@/assets/4.jpg" alt=""></div>
        <div><img src="@/assets/5.jpg" alt=""></div>
        <div><img src="@/assets/6.jpg" alt=""></div>
        <div class="tyut">Welcome to TYUT</div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Content-Home',

  data() {
    return {
      
    };
  },
};
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

section {
    position: relative;
    width: 300px;
    height: 200px;
    cursor: pointer;
    /* 很关键，preserve-3d是物体看起来有3d效果 */
    transform-style: preserve-3d;
    animation: rotate 20s linear infinite;
}
.tyut{
    position: absolute;
    color: white;
    top: -150px;
    font-size: 40px;
}
section:hover{
    animation-play-state: paused;
}
section div {
    text-align: center;
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    /* 用来实现倒影效果 */
    -webkit-box-reflect:bottom 15px
    -webkit-linear-gradient(transparent 10%,rgba(255,255,255,.3));
}           

section div img {
    width: 300px;
    height: 200px;

}

section div:nth-child(1) {
    transform: translateZ(300px);
}

section div:nth-child(2) {
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
}
@keyframes rotate{
    0%{
        transform: rotateY(0);
    }
    100%{
        transform: rotateY(360deg);
    }
}
</style>
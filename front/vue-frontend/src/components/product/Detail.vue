<template>
  <div>
    <div class="topContent">
      <div class="topBox left">
        <div class="imageBox"></div>
      </div>
      <div class="topBox right">
        <div class="name">다이아 반지</div>
        <div class="price">PRICE - 10000원</div>
        <div class="trans">
          <p>배송 : 국내배송</p>
          <p>배송 방법 : 택배</p>
          <p>배송비 : 2500원</p>
        </div>
        <div class="count">
          <tr>
            <td class="text">수량</td>
            <td>
                <button type ="button" @click="$store.commit('minus')">-</button>
                <input type="text" readonly="readonly" :value="`${$store.state.count}`">
                <button type="button" @click="$store.commit('plus')">+</button>
            </td>
          </tr>
        </div>
        <div class="totPrice">총 상품금액 - {{$store.state.totalPrice}}원</div>
        <div class="button">
          <v-btn color="#FBEF97" x-large @click="order">구매하기</v-btn>
          <v-btn color="#F4F2E7" x-large @click="cart">장바구니</v-btn>
        </div>
      </div>
    </div>

    <div class="tab">
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" @click="changeVersion(0)" :class="{'active' : version == 0}">상세정보</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"  @click="changeVersion(1)" :class="{'active' : version == 1}">리뷰</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"  @click="changeVersion(2)" :class="{'active' : version == 2}">Q&A</a>
        </li>
      </ul>
      <div class="tab-content">
        <CONTENT v-if="version == 0"></CONTENT>
        <REVIEW v-if="version == 1"></REVIEW>
        <QNA v-if="version == 2"></QNA>
      </div>
    </div>
  </div>
</template>

<script>
import CONTENT from './Content'
import REVIEW from './Review'
import QNA from './Qna'

export default {
  components: {
    CONTENT, REVIEW, QNA
  },
  data () {
    return {
      version: 0
    }
  },
  methods: {
    cart () {
      location.href = '/cart'
    },
    order () {
      location.href = '/order'
    },
    changeVersion (index) {
      this.version = index
    }
  }
}
</script>

<style scoped>
.topContent {
  margin: 5rem 0;
  display: flex;
  justify-content: center;
}
.topBox {
  margin: 0 0.1rem;
  width: 28rem;
  padding-bottom: 2rem;
  border: 0.1rem solid #6b6868;
  border-radius: 10px;
}
.imageBox {
  width: 300px;
  height: 300px;
  margin: 4rem auto;
  background-size: cover;
  background-image: url(https://ifh.cc/g/W8P7ct.jpg);
}
.name {
  font-weight: 700;
  font-size: 1.5rem;
  margin: 4rem 0 1rem 2rem;
}
.price{
  text-align: right;
  font-weight: 700;
  font-size: 1.2rem;
  float: right;
  margin-right: 3rem;
  width: fit-content;
}
.trans {
  margin: 3rem 0 3rem 2rem;
  font-size: 0.7rem;
  color: #b4b9be;
}
.count {
  margin: 2rem 0 0 2em;
}
.count .text {
  padding-right: 2rem;
  font-size: 0.9rem;
}
.count button {
  outline: none;
  background-color: white;
  padding: 0 0.3rem;
  border-radius: 50%;
  border: 1px solid black;
  margin: 0 0.5rem;
  font-size: 0.7rem;
  font-weight: 700;
  box-shadow: 1px 0.5px 0 rgb(0,0,0,0.5);
}
.count button:active {
  box-shadow: 1px 0px 0 rgb(0,0,0,0.5);
  position: relative;
  top: 0.5px;
}
.count input {
  font-size: 0.7rem;
  font-weight: 700;
  border-radius: 2px;
  outline: none;
  border: 1px solid black;
  text-align:center;
}
.totPrice {
  text-align: right;
  font-weight: 700;
  font-size: 1.1rem;
  margin: 2rem 3rem 0 0;
}
.button {
  display: flex;
  justify-content: center;
  margin-top: 2rem;
}
.button button {
  border: 1px solid black;
  margin: 0 0.6rem;
  padding: 0.5rem 2rem;
  font-weight: 700;
}

.tab {
  width: 56rem;
  margin: 0 auto;
}
.nav-item {
  width: 33%;
}
.nav-link {
  color: #b4b9be;
  cursor: pointer;
  transition: .5s;
}
</style>

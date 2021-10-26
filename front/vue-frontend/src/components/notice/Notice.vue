<template>
  <div class="outer">
    <p>공지사항</p>
    <p class="add"><a class="btn btn-dark" href="/regnotice">공지사항 등록</a></p>
    <table>
      <colgroup>
      <col width="70"/><col width="450"/><col width="140"/><col width="130"/>
      </colgroup>

      <thead>
        <tr>
          <th>#</th>
          <th>TITLE</th>
          <th style="text-align:center;">DATE</th>
          <th style="text-align:center;">HIT</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="i in 7" :key="i">
            <td class="tdNo">{{i}}</td>
            <td class="tdTitle" @click="detail">공지사항 제목 </td>
            <td class="tdDate" style="text-align:center;"> 2021-10-20</td>
            <td class="tdCount">11</td>
        </tr>
      </tbody>
    </table>

    <!-- pagination -->
    <div class="page">
      <div class="box">
        <a href="#" class="arrow">&laquo;</a>
        <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">7</a>
        <a href="#">8</a>
        <a href="#" class="arrow">&raquo;</a>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  methods: {
    detail () {
      location.href = '/notice_'
    }
  }
}
</script>

<style scoped>
.outer {
  width: 750px;
  margin: 4rem auto;
}
p {
  font-weight: 700;
  font-size: 1.5rem;
  margin-bottom: 1rem;
}
th {
  border-bottom: 1px solid #333333;
  padding: 1rem;
}
td {
  border-bottom: 1px solid #333333;
  padding: 0.7rem;
}
thead {
  background-color:#fefff2;
}
.toNo, .tdDate , .tdCount {
  text-align:center;
}
.tdTitle {
  cursor: pointer;
}
.tdTitle:hover {
  font-size: 1.02rem;
}
.page {
  display: inline-block;
  width: 750px;
  margin-top: 2rem;
}
.box {
  margin: 0 auto;
  width: fit-content;
}
.page a {
  color: black;
  float: left;
  padding: 4px 12px;
  text-decoration: none;
  border-radius:50%;
  margin: 0 0.5rem;
}
.page a.active {
  background-color: #fde8b9;
  color: white;
}
.page a:hover:not(.active) {
  background-color: silver;
}

.add {
  margin: 0;
  width: 750px;
  height: 50px;
}
.btn-dark {
  float: right;
}
.btn-dark:focus {
  box-shadow: none;
}
.btn-dark:hover {
  background-color: gray;
}
</style>

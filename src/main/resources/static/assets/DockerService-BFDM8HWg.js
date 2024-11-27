import{c as a,n}from"./confirm-BdaP8Y2Q.js";import{D as c,G as i}from"./index-BXNFt6Ee.js";const s=c.create();i(s);const o={getContainerAll:async()=>{const e=(await s.get("/docker/container")).data.string;return o.jsonParser(e)},getImageAll:async()=>{const e=(await s.get("/docker/image")).data.string;return o.jsonParser(e)},jsonParser:t=>{if(!t)return[];const e=t.trim().split(/\r?\n/);return Object.assign([],e.map(r=>JSON.parse(r)))},startContainer:(t,e)=>{a("컨테이너를 실행하시겠습니까?","컨테이너").then(()=>{s.post("/docker/container/start",{containerName:t.ID}).then(r=>{n("컨테이너","컨테이너 실행 완료","success"),e&&e()})})},pullImage:(t,e)=>{a("이미지를 다운로드하시겠습니까?","이미지").then(()=>{s.post("/docker/image/pull",t).then(r=>{n("이미지","이미지 다운로드 완료","success"),e&&e()})})},startImage:(t,e)=>{a("이미지를 실행하시겠습니까?","이미지").then(()=>{s.post("/docker/image/start",t).then(r=>{n("이미지","이미지 실행 완료","success"),e&&e()})})},stopContainer:(t,e)=>{a("컨테이너를 중단하시겠습니까?","컨테이너").then(()=>{s.post("/docker/container/stop",{containerName:t.ID}).then(r=>{n("컨테이너","컨테이너 중단 완료","success"),e&&e()})})},delContainer:(t,e)=>{a("컨테이너를 삭제하시겠습니까?","컨테이너").then(()=>{s.post("/docker/container/delete",{containerName:t.ID}).then(r=>{n("컨테이너","컨테이너 삭제 완료","success"),e&&e()})})},delImage:(t,e)=>{a("이미지를 삭제하시겠습니까?","이미지").then(()=>{s.post("/docker/image/delete",{imageName:t.ID}).then(()=>{n("이미지","이미지 삭제 완료","success"),e&&e()})})}};export{o as D};

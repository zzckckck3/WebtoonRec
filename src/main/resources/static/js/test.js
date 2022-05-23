function loadWebtoon(){
    return fetch("/api/v1/webtoon-api/webtoon/all?offset=0&&limit=30")
        .then((response) => response.json())
        .then((json) => json.items);
}
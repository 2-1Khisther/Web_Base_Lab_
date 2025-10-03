let post = [
    {id: 1, author: "Alice", contentLenght: 100, likes: 10},
    {id: 2, author: "Bob", contentLenght: 200, likes: 20},
    {id: 3, author: "Cath", contentLenght: 300, likes: 30},
    {id: 4, author: "Alice", contentLenght: 400, likes: 40},
    {id: 5, author: "Bob", contentLenght: 500, likes: 50},
];
//add like every post and return total
function getTotalLikes (post) {
    let total = 0;
    for ( let i = 0; i < post.length; i++) {
        total = total + post[i].likes;
    }
    return total;
}
//new list of post if contentlength is bigger than minLength
function filterContentLenght (post, minLenght) {
    let result = [];

    for (let i = 0; i < post.length; i++) {
        if (post[i].contentLenght > minLenght) {
            result.push(post[i]);
       }
    }
    return result;
}

// find and return the post that has a highest number of likes
function mostLikedPost (post) {
    let motsLiked = post[0];
    for (let i = 1; i < post.length; i++) {
        if (post[i].likes > motsLiked.likes) {
            motsLiked = post[i];
        }
    }
    return motsLiked
}

function groupofAuthor (post) {
 let grouped = {};
 for (let i = 0; i < post.length; i++){
    let author = post[i].author;
    if(!grouped[author]) {
         grouped[author] = [];
    }
    grouped[author].push(post[i]);
 }
 return grouped;
}

function fetchNewPost(callback) {
    setTimeout(function() {
        let newPost = [ ];
        callback(newPost);
    }, 2000);
}
fetchNewPost(function(newPost){
    console.log("i can now use newposts: ", newPost);
});

console.log ("Total Likes: " + getTotalLikes(post));
console.log ("Post longer than 100: ", filterContentLenght(post, 100));
console.log ("Most Liked Post: ", mostLikedPost(post));
console.log ("Posts Grouped by Author: ", groupofAuthor(post));
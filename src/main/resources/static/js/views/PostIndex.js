import createView from "../createView.js";

const POST_URI = "http://localhost:8081/api/posts"
export default function PostIndex(props) {
    // language=HTML
    return `
        <div class="container-fluid">
            <header>
                <h1>Posts Page</h1>
            </header>
            <main>
                <div id="post-container">
                    ${props.posts.map(post => `
                        <h3 id="title-${post.id}">${post.title}</h3>
                        <p id="content-${post.id}">${post.content}</p>
                        <p id="author-${post.id}">${post.author.username}</p>
                        <p id="email-${post.id}">${post.author.email}</p>
                        <button type="button" class="btn edit-btn primary mb-3" data-id="${post.id}" >Edit</button>
                        <button type="button" class="btn delete-btn primary mb-3" data-id="${post.id}">Delete</button>`)
                            .join('')}
                </div>

                <h3>Add a Post</h3>
                <form id="add-post-form">
                    <div class="mb-3">
                        <input disabled type="text" class="form-control" id="add-post-id" value="0">
                    </div>
                    <div class="mb-3">
                        <label for="add-post-title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="add-post-title" placeholder="Post title">
                    </div>
                    <label for="add-post-content" class="form-label">Content</label>
                    <textarea class="form-control" id="add-post-content" rows="3" placeholder="Post content"></textarea>
                    <div>
                        <button type="button" class="btn btn-primary nb-3" id="add-post-button">Add Post</button>
                        <button type="button" class="btn btn-primary nb-3" id="save-post-button">Save Post</button>
                    </div>
                </form>
        </div>
        </main>


    `;
}

export function PostsEvent() {
    createAddPostListener();
    createEditEventListener()
    createDeleteEventLister()
    createSaveEventListener()
}

function createAddPostListener() {
    console.log("Adding add post listener");
    $("#add-post-button").click(function () {
        const newPost = {
            title: $("#add-post-title").val(),
            content: $("#add-post-content").val()
        }
        console.log("Ready to add" + newPost);
        console.log(newPost);

        const request = {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newPost)
        }
        fetch(POST_URI, request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts");
        });
    });
}

function createSaveEventListener(){
    $("#save-post-button").click(function () {
        const id = $(this).data("id")
        const newPost = {
            title: $("#add-post-title").val(),
            content: $("#add-post-content").val()
        }
        console.log("Ready to add" + newPost);
        console.log(newPost);

        const request = {
            method: "PUT",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newPost)
        }
        fetch(POST_URI + "/" + id, request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts");
        });
    });
}

function createEditEventListener() {
    $('.edit-btn').click(function () {
        const id = $(this).data("id");
        const oldTitle = $(`#title-${id}`).html();
        const oldContent = $(`#content-${id}`).text();
        $("#add-post-id").val(id)
        $("#add-post-title").val(oldTitle)
        $("#add-post-content").val(oldContent)
        $(`#save-post-button`).data("id", id)

    });

}

function createDeleteEventLister() {
    $('.delete-btn').click(function () {
        const id = $(this).data("id")
        console.log("Deleted " + id)

        const request = {
            method: 'DELETE',
            headers:{
                'Content-Type': 'application/json',
            }
        };
        fetch(`${POST_URI}/${id}`, request).then(res => {
            console.log("Deleted Successfully: " + res.status);
        }).catch(error => {
            console.log("Delete Error: " + error);
        }).finally(() => {
            createView("/post");
        });
    });
}

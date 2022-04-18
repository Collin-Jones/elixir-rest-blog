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
                        <h3>${post.title}</h3>
                        <p>${post.content}</p>
                        <button type="button" class="btn edit-btn btn primary mb-3" data-id="$(post.id)">Edit</button>
                        <button type="button" class="btn delete-btn btn primary mb-3" data-id="$(post.id)">Delete</button>`)
                    .join('')}
                </div>

                <div id="add-post-container">
                    <form id="add-post-form">
                        <div class="mb-3">
                            <label for="add-post-title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="add-post-title" placeholder="Enter title">
                        </div>
                        <div class="mb-3">
                            <label for="add-post-content" class="form-label">Content</label>
                            <textarea class="form-control" id="add-post-content" rows="3"
                                      placeholder="Enter content"></textarea>
                        </div>
                        <button type="button" class="btn btn-primary nb-3">Save Post</button>
                    </form>
                </div>
            </main>
        </div>

    `;
}

export function PostsEvent() {
    createAddPostListener();
    EditEventListener();
    DeleteEventLister();
}

function createAddPostListener() {
    console.log("Adding add post listener");
    $("#add-post-button").click(function () {
        const title = $("#add-post-title").val()
        const content = $("#add-post-content").val()
        const newPost = {
            title,
            content
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

function EditEventListener() {
    $('#edit-btn').click(function () {
        const id = $(this).data("id")
        const title = $("#title " + id).text();
        console.log(id, title)
    });
}

function DeleteEventLister() {
    $('#delete-btn').click(function () {
        const id = $(this).data("id")
        const title = $("#title " + id).text();
        console.log(id, title)
    });
}

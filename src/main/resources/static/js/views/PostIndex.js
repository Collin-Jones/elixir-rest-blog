export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div>
                ${props.posts.map(post => {
        return `<h3>${post.title}</h3>
        <p>${post.content}</p>`;
    }).join('')}
            </div>
        </main>
    `;
}
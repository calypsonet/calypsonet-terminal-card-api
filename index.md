## Welcome Calypsonet Terminal Card Java API

[Click here to view the Javadoc associated to this API.](https://calypsonet.github.io/calypsonet-terminal-card-java-api/1.0)

{% comment %}
    Bullet list menu of pages at the current level.

    Use pages at the current level excluding the page itself.
{% endcomment %}

<ul class="page-list">
    {% assign pages = site.pages | sort: 'title' %}

    {%- for item in pages %}
        {%- if item.dir == page.dir and item.path != page.path %}
            <li>
                <a href="{{ item.url | relative_url }}">
                    {% include logo.html name=item.logo %}

                    <span>{{ item.title }}</span>
                </a>

                {%- comment -%} Note that markdownify generates p tags that causes wrapping {%- endcomment -%}
                {%- if page.description %}
                    <i>{{ item.description | escape | markdownify }}</i>
                {% endif -%}
            </li>
        {% endif -%}
    {% endfor -%}
</ul>